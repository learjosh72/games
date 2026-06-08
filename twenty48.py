from pynput import keyboard
import random
import sys
import random
import copy

from PySide6.QtCore import Qt
from PySide6 import QtCore, QtWidgets, QtGui
from PySide6.QtWidgets import *
from PySide6.QtGui import QFont

class Game:
    def __init__(self):
        self.gamestate = [[None,None,None,None],[None,None,None,None],[None,None,None,None],[None,None,None,None]]
        #self.gamestate = [[2,4,8,16],[32,64,128,256],[512,1024,2048,4096],[4096,4096,4096,4096]]


    def left(self):
        prev = copy.deepcopy(self.gamestate)
        score = 0
        for i in range(4):
            row = [x for x in self.gamestate[i] if x is not None]
            j=0
            while j < len(row)-1:
                if row[j] == row[j+1]:
                    row[j] *= 2
                    score+=row[j]
                    row.pop(j+1)
                j += 1
            self.gamestate[i] = row + [None] * (4-len(row))
        return prev, score

    def right(self):
        prev = copy.deepcopy(self.gamestate)
        score = 0
        for i in range(4):
            row = [x for x in self.gamestate[i][::-1] if x is not None]
            j=0
            while j < len(row)-1:
                if row[j] == row[j+1]:
                    row[j] *= 2
                    score+=row[j]
                    row.pop(j+1)
                j += 1
            self.gamestate[i] = [None] * (4-len(row)) + row[::-1]
        return prev, score

    def up(self):
        prev = copy.deepcopy(self.gamestate)
        score = 0
        self.gamestate = [list(row) for row in zip(*self.gamestate)]
        for i in range(4):
            row = [x for x in self.gamestate[i] if x is not None]
            j=0
            while j < len(row)-1:
                if row[j] == row[j+1]:
                    row[j] *= 2
                    score += row[j]
                    row.pop(j+1)
                j += 1
            self.gamestate[i] = row + [None] * (4-len(row))

        self.gamestate = [list(row) for row in zip(*self.gamestate)]
        return prev, score

    def down(self):
        prev = copy.deepcopy(self.gamestate)
        score = 0
        self.gamestate = [list(row) for row in zip(*self.gamestate)]
        for i in range(4):
            row = [x for x in self.gamestate[i][::-1] if x is not None]
            j = 0
            while j < len(row) - 1:
                if row[j] == row[j + 1]:
                    row[j] *= 2
                    score += row[j]
                    row.pop(j + 1)
                j += 1
            self.gamestate[i] = [None] * (4 - len(row)) + row[::-1]

        self.gamestate = [list(row) for row in zip(*self.gamestate)]
        return prev, score



    def on_press(self,key):
        # try:
        #     print('alphanumeric key {0} pressed'.format(
        #         key.char))
        # except AttributeError:
        #     print('special key {0} pressed'.format(
        #         key))
        if key == keyboard.Key.down:
            print(key)
            #implement logic for shift
            prev = self.down()
            if prev != self.gamestate:
                self.sample()

        elif key == keyboard.Key.up:
            print(key)
            prev = self.up()
            if prev != self.gamestate:
                self.sample()
        elif key == keyboard.Key.right:
            print(key)
            prev = self.right()
            if prev != self.gamestate:
                self.sample()
        elif key == keyboard.Key.left:
            # implement logic for left shift
            print(key)

            prev = self.left()
            if prev != self.gamestate:
                self.sample()


    def on_release(self, key):
        if self.checkend() == 1:
            print("End")
            return False

        #print(gamestate)
        for x in range(4):
            print(self.gamestate[x])
        if key == keyboard.Key.esc:
            # Stop listener
            return False
        #check for end

    def sample(self):
        while True:
            i = random.randint(0,3)
            j = random.randint(0,3)
            a = random.choices([2,4], weights=[.9,.1])[0]
            if self.gamestate[i][j] == None:
                self.gamestate[i][j] = a
                break

    def checkend(self):
        one = 1
        two = 0
        for i in range(4):
            for j in range(4):
                if (self.gamestate[i][j] == None):
                    one = 0
        for i in range(4):
            for j in range(4):
                if (j != 3 and self.gamestate[i][j] != self.gamestate[i][j+1]):
                    two += 1
                if (j != 0 and self.gamestate[i][j] != self.gamestate[i][j-1]):
                    two += 1
                if (i != 3 and self.gamestate[i][j] != self.gamestate[i+1][j]):
                    two += 1
                if (i != 0 and self.gamestate[i][j] != self.gamestate[i-1][j]):
                    two += 1
        if two == 48 and one == 1:
            return 1
        else:
            return 0


    def start(self):
        i = random.randint(0,3)
        j = random.randint(0,3)
        self.gamestate[i][j] = 2
        self.sample()
        # print(self.gamestate)
        # # Collect events until released
        # with keyboard.Listener(
        #     on_press=self.on_press,
        #     on_release=self.on_release) as listener:
        #     listener.join()
        #
        # # ...or, in a non-blocking fashion:
        # listener = keyboard.Listener(
        #     on_press=self.on_press,
        #     on_release=self.on_release)
        # listener.start()






