from IPython.display import Image
from IPython.display import Video

from sklearn.datasets import fetch_openml
mnist = fetch_openml(name="mnist_784")

print(mnist.keys())

data = mnist.data
labels = mnist.target

print(data.shape)

#vizualizáció
import matplotlib.pyplot as plt

def viz(test_img,test_label,size=(28,28)):
    plt.imshow(test_img.reshape(size[0],size[1]),cmap="Greys")
    plt.axes("off")
    plt.title(str(test_label))
    plt.show()

import numpy as np

choice = np.random.choice(np.arange(data.shape[0]+1))
#teszt kép kiválasztása
test_img = data.iloc[choice].values

#teszt label kiválasztása
test_label = mnist.target.iloc[choice]
print(viz(test_img,test_label))