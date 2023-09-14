import pyautogui
import time

# doc: https://pyautogui.readthedocs.io/en/latest/mouse.html

# installer python sur l'ordinateur avec "https://www.python.org/"
# lancer la commande "python get-pip.py" dans le cmd pour installer pip
# lancer la commande "pip install pyautogui" dans le cmd pour installer pyautogui
# avec le cmd, aller dans le meme dossier que le fichier
#lancer la commande "python .\script_move_mouse.py"

#Ce script dessine une saucisse toutes les 30 secondes
while True:
    pyautogui.moveTo(300, 500)
    pyautogui.moveTo(150, 500, 0.2)#boule # moves mouse to X of 150, Y of 50 over 0.2 seconds
    pyautogui.moveTo(150, 300, 0.2)#boule
    pyautogui.moveTo(400, 300, 0.2)#boule
    pyautogui.moveTo(400, 400, 0.2)#boule
    pyautogui.moveTo(1000, 400, 0.6)#calibre
    pyautogui.moveTo(1000, 350, 0.2)#pointe
    pyautogui.moveTo(1200, 500, 0.2)#pointe
    pyautogui.moveTo(1000, 650, 0.2)#pointe
    pyautogui.moveTo(1000, 600, 0.2)#pointe
    pyautogui.moveTo(400, 600, 0.6)#calibre
    pyautogui.moveTo(400, 700, 0.2)#boule
    pyautogui.moveTo(150, 700, 0.2)#boule
    pyautogui.moveTo(150, 500, 0.2)#boule
    pyautogui.moveTo(300, 500, 0.2)#boule
    time.sleep(30.0)

# print(pyautogui.size())
# x, y = pyautogui.position()
# print(x)