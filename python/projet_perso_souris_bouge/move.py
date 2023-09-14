import pyautogui
import time

# doc: https://pyautogui.readthedocs.io/en/latest/mouse.html

# installer python sur l'ordinateur avec "https://www.python.org/"
# lancer la commande "python get-pip.py" dans le cmd pour installer pip
# lancer la commande "pip install pyautogui" dans le cmd pour installer pyautogui
# avec le cmd, aller dans le meme dossier que le fichier
#lancer la commande "python .\mouse.py"


while True:
    pyautogui.moveTo(150, 150)
    pyautogui.moveTo(1000, 150, 0.9)
    pyautogui.moveTo(150, 150, 0.9)
    time.sleep(30.0)



# print(pyautogui.size())
# x, y = pyautogui.position()
# print(x)
