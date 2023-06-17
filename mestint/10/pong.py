import pygame
import numpy as np
from tqdm import tqdm

# colors
BLACK = (0,0,0)
WHITE = (255,255,255)
RED = (255,0,0)
GREEN = (0,255,0)
BLUE = (0,0,255)

# symbols
SIGN_EMPTY = ' '
SIGN_BALL = 'o'
SIGN_PLAYER = "x"

# the window size
SPACE_SIZE = (20,20)

ZOOM_SIZE = 10

# 3 muveletunk van, amelyeket az ugynok barmikor megtehet:
ACTION_IDLE = 'IDLE'
ACTION_LEFT = 'LEFT'
ACTION_RIGHT = 'RIGHT'

ACTIONS = [
    ACTION_IDLE,
    ACTION_LEFT,
    ACTION_RIGHT
]

# A lapát kezdő koordinátái
rect_x = SPACE_SIZE[0] // 2
rect_y = SPACE_SIZE[1] - 2

# lapát sebessége
rect_change_x = 0
rect_change_y = 0

# lapát mérete
rect_size_x = 5
rect_size_to_sides_x = rect_size_x // 2
rect_size_y = 1

#labda kezdeti helyzete
ball_x = SPACE_SIZE[0] // 2
ball_y = 1

# labda sebessege
ball_change_x = 1
ball_change_y = 1
ball_size_to_sides = 1

# a dictben kovetjuk azokat az allapotokat amikkel eddig talalkoztunk
state_to_id = {}

# lehetseges allapotok szama
num_states = SPACE_SIZE[0] * SPACE_SIZE[1] * SPACE_SIZE[0] * SPACE_SIZE[1] * 2 * 2

# képernyő méret
screen = 0

clock = 0

#agent
agent = None

def drawrect(screen, x, y):
    pygame.draw.rect(screen, RED, [(x - rect_size_to_sides_x) * ZOOM_SIZE, y * ZOOM_SIZE, ZOOM_SIZE * rect_size_x, ZOOM_SIZE])

def encode_state(ball_x, ball_y, rect_x, rect_y, ball_change_x, ball_change_y):
    return (ball_x, ball_y, rect_x, rect_y, ball_change_x, ball_change_y)

def reset():
    global ball_change_x
    global ball_change_y
    global ball_size_to_sides
    global ball_x
    global ball_y
    global rect_x
    global rect_x
    global rect_change_x
    global rect_change_y

    ball_change_x = 1
    ball_change_y = 1
    ball_size_to_sides = 1

    ball_x = SPACE_SIZE[0] // 2
    ball_y = 1

    rect_x = SPACE_SIZE[0] // 2
    rect_y = SPACE_SIZE[1] - 1

    rect_change_x = 0
    rect_change_y = 0

def init_pong():
    global screen
    global clock

    pygame.init()

    size = (SPACE_SIZE[0] * ZOOM_SIZE, SPACE_SIZE[1] * ZOOM_SIZE)
    screen = pygame.display.set_mode(size)
    pygame.display.set_caption('pong')

    clock = pygame.time.Clock()
    print('Pong init')

def play_episodes(n_episodes=10_000, max_epsilon=1.0, min_epsilon=0.01, decay_rate=0.0001, gamma=0.99, learn=True, viz=False, human=False, log=False):
    global ball_change_x
    global ball_change_y
    global ball_size_to_sides
    global ball_x
    global ball_y
    global rect_x
    global rect_y
    global rect_change_x
    global rect_change_y
    global state_to_id
    global clock

    rewards = []
    epsilon_history = []

    #végignézzük az epizódokat
    for episode in tqdm(range(n_episodes)):
        done = False

        # Epszilon csökkentése
        epsilon = min_epsilon + (max_epsilon - min_epsilon) * np.exp(-decay_rate * episode)

        # Környezet visszaállítása
        total_reward = 0
        reset()

        # Első állapot beállítása
        state = encode_state(ball_x, ball_y, rect_x, rect_y, ball_change_x, ball_change_y)
        if state not in state_to_id:
            state_to_id[state] = len(state_to_id)

        while not done:
            reward = 0

            # háttér színének beállítása
            screen.fill(BLACK)

            if not human:
                # az agenttől akciot kerunk es ennek megfeleloen allitjuk be a jatekos mozgasat
                action = agent.act(state=state_to_id[state], epsilon=epsilon)
                action_name = ACTIONS[action]

                if action_name == ACTION_LEFT:
                    rect_change_x = -1
                elif action_name == ACTION_RIGHT:
                    rect_change_x = 1
                elif ACTION_IDLE:
                    rect_change_x = 0
                else:
                    print("error unknown ation", action)
                    exit(-1)
            else:
                # emberi input
                action = 0
                for event in pygame.event.get():
                    if event.type == pygame.QUIT:
                        done = True
                    elif event.type == pygame.KEYDOWN:
                        if event.key == pygame.K_LEFT:
                            rect_change_x = -1
                        elif event.key == pygame.K_RIGHT:
                            rect_change_x = 1
                    elif event.type == pygame.KEYUP:
                        if event.key == pygame.K_LEFT or event.key == pygame.K_RIGHT:
                            rect_change_x = 0
                        elif event.key == pygame.K_UP or event.key == pygame.K_DOWN:
                            rect_change_y = 0

            # megvaltoztatjuk a jatekos es a labda helyzetet a vegrehajtott akcionak megfeleloen
            rect_x += rect_change_x
            rect_y += rect_change_y

            # labda mozgásának kezelése
            if ball_x < 0:
                ball_x = 0
                ball_change_x *= -1
            elif ball_x > SPACE_SIZE[0]:
                ball_x = SPACE_SIZE[0]
                ball_change_x *= -1
            elif ball_y < 0:
                ball_y = 0
                ball_change_y *= -1
            # amikor a labda és a játékos utkozik noveljuk a jutalmat es megvaltoztatjuk a ...
            elif ball_x + ball_size_to_sides >= rect_x - rect_size_to_sides_x and \
                ball_x - ball_size_to_sides <= rect_x + rect_size_to_sides_x and \
                ball_y == SPACE_SIZE[1] -1:
                ball_y *= -1
                reward = 1
            # akkor fejezzük be az epizódot amikor a játékos nem találja el a labdát
            elif ball_y > SPACE_SIZE[1] -1:
                ball_change_y *= -1
                done = True
                reward = -1

            # most uj allapotba kerulunk mert megtettunk egy bizonyos intezkedest
            new_state = encode_state(ball_x, ball_y, rect_x, rect_y, ball_change_x, ball_change_y)
            if new_state not in state_to_id:
                state_to_id[new_state] = len(state_to_id)

            ball_x += ball_change_x
            ball_y += ball_change_y

            # ha az agent tullep a kepernyon mindket oldalon akkor megszakitjuk az epizodot
            if rect_x - rect_size_to_sides_x < 0:
                rect_x = 0 + rect_size_to_sides_x
                reward = -1
                done = True
            if rect_x > SPACE_SIZE[0] - rect_size_to_sides_x - 1:
                rect_x = SPACE_SIZE[0] - rect_size_to_sides_x - 1
                reward = -1
                done = True

            # vizualizaljuk
            if viz:
                # labda
                pygame.draw.rect(screen, WHITE, [(ball_x - ball_size_to_sides) * ZOOM_SIZE,
                                                 (ball_y - ball_size_to_sides) * ZOOM_SIZE,
                                                 ZOOM_SIZE * ball_size_to_sides,
                                                 ZOOM_SIZE * ball_size_to_sides])
                # rect
                drawrect(screen, rect_x, rect_y)
                pygame.display.flip()
                clock.tick(60)

            # frissitjuk a q tablat
            if learn:
                agent.learn(state_to_id[state], action, reward, state_to_id[new_state], gamma)

            #a kovetkezo idotullepes aktualis allapota az aktualis newstate lesz
            state = new_state
            total_reward += reward

        if log:
            print("total reward:", total_reward)

        rewards.append(total_reward)
        epsilon_history.append(epsilon)

    return rewards, epsilon_history 