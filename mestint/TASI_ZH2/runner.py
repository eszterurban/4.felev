import pong as pong
pong.init_pong()

from qla import QLearningAgent

pong.agent = QLearningAgent(n_states=pong.num_states, n_actions=3, learning_rate=1.0)
pong.agent

# a jatek fo kore
clock = pong.pygame.time.Clock()

rewards, epsilon_history = pong.play_episodes(
    n_episodes=50_000,
    max_epsilon=1.0,
    min_epsilon=0.05,
    decay_rate=0.0001,
    gamma=0.95,
    learn=True,
    viz=False,
    human=False,
    log=False
)

import matplotlib.pyplot as plt

#ellenőrízhetjük az ügynök teljestményéne történetét
plt.plot(epsilon_history)
plt.show()

plt.plot(rewards)
plt.show()

import pickle

with open("agent.pkl","rb") as f:
    pong.agent = pickle.load(f)
with open("state_to_id.pkl","rb") as f:
    pong.state_to_id = pickle.load

#most megfigyelhetjük hogy teljesít a képzett agent
rewards, epsilon_history = pong.play_episodes(10,max_epsilon=0,min_epsilon=0,decay_rate=0,gamma=0,learn=False,viz=True,log=True)
plt.plot(epsilon_history)
plt.show()

with open("agent.pkl","wb") as f:
    pickle.dump(pong.agent,f)
with open("state_to_id.pkl","wb") as f:
    pickle.dump(pong.state_to_id,f)