import sys
import random

from PySide6.QtCore import Qt, Slot
from PySide6 import QtCore, QtWidgets, QtGui
from PySide6.QtWidgets import *
from PySide6.QtGui import QFont
from twenty48 import Game

class MyWidget(QtWidgets.QWidget):
    def __init__(self):
        super().__init__()

        self.logic = Game()
        self.logic.start()
        self.score = 0
        self.setFocusPolicy(Qt.StrongFocus)

        self.board = [[None, None, None, None],
                      [None, None, None, None],
                      [None, None, None, None],
                      [None, None, None, None]]
        self.setWindowTitle("2048")
        outer_layout = QtWidgets.QVBoxLayout()
        score_layout = QtWidgets.QHBoxLayout()

        self.overlay = QWidget(self)
        self.overlay.setStyleSheet("""
            background-color: rgba(48,48,48,180);
        """)


        layout = QVBoxLayout(self.overlay)

        game_over_label = QLabel("GAME OVER")
        game_over_label.setAlignment(Qt.AlignCenter)

        game_over_label.setStyleSheet("""
            background: transparent;
            color: white;
            font-size: 48px;
            font-weight: bold;
        """)

        self.replay_button = QPushButton("Play Again")

        self.replay_button.setStyleSheet("""
            background-color: #303030;
            color: white;
            border: 2px solid gray;
            border-radius: 8px;
            padding: 8px;
            font-size: 16px;
        """)

        layout.addStretch()
        layout.addWidget(game_over_label)
        layout.addWidget(self.replay_button)
        layout.addStretch()

        self.overlay.hide()
        #self.overlay.raise_()

        self.replay_button.clicked.connect(self.restart_game)



        self.grid = QtWidgets.QGridLayout()
        self.grid.setSpacing(2)
        self.labels = []
        tile_size = 100
        spacing = 5

        board_size = 4 * tile_size + 3 * spacing
        self.setFixedSize(board_size+20, board_size+100)
        self.grid.setContentsMargins(0, 0, 0, 0)
        outer_layout.setContentsMargins(5, 5, 5, 5)
        font = QFont()
        font.setPointSize(24)
        font.setBold(True)

        for row in range(4):
            label_row = []

            for col in range(4):
                label = QLabel("")
                label.setAlignment(Qt.AlignCenter)
                label.setFont(font)
                label.setFixedSize(100,100)

                label.setStyleSheet("""
                                        background-color: lightgray;
                                        border: 2px solid black;""")

                self.grid.addWidget(label, row, col)
                label_row.append(label)

            self.labels.append(label_row)

        self.score_label = QtWidgets.QLabel(f"Score: {self.score}")
        self.score_label.setFont(font)
        self.score_label.setFixedSize(200,100)
        score_layout.addWidget(self.score_label)

        outer_layout.addLayout(score_layout)
        outer_layout.addLayout(self.grid)

        self.setLayout(outer_layout)
        self.update_board()


    def update_board(self):
        COLORS = {
            None: "#545454",
            2: "#BAAC9E",
            4: "#D6B28D",
            8: "#E58C50",
            16: "#F27544",
            32: "#C45233",
            64: "#E53F22",
            128: "#F0C759",
            256: "#EBBA36",
            512: "#D1A11F",
            1024: "#F2BB07",
            2048: "#FFC200",
            4096: "#AC4DF0",
        }
        for row in range(4):
            for col in range(4):
                value = self.logic.gamestate[row][col]

                if value is None:
                    self.labels[row][col].setText("")
                else:
                    self.labels[row][col].setText(str(value))

                color = COLORS.get(value, "#030303")

                self.labels[row][col].setStyleSheet(f"""
                                background-color: {color};
                                border: 2px solid black;
                            """)

    def update_score(self, scoreinc):
        self.score += scoreinc
        self.score_label.setText(f"Score: {self.score}")


    def keyPressEvent(self, event):

        if event.key() == Qt.Key_Left:
            prev, scoreinc = self.logic.left()
            if prev != self.logic.gamestate:
                self.logic.sample()

            if self.logic.checkend() == 1:
                self.overlay.raise_()
                self.overlay.show()
                print("End")


            self.board = self.logic.gamestate
            self.update_score(scoreinc)

        elif event.key() == Qt.Key_Right:
            prev, scoreinc = self.logic.right()
            if prev != self.logic.gamestate:
                self.logic.sample()

            if self.logic.checkend() == 1:
                self.overlay.raise_()
                self.overlay.show()
                print("End")


            self.board = self.logic.gamestate
            self.update_score(scoreinc)

        elif event.key() == Qt.Key_Up:
            prev, scoreinc = self.logic.up()
            if prev != self.logic.gamestate:
                self.logic.sample()

            if self.logic.checkend() == 1:
                self.overlay.raise_()
                self.overlay.show()
                print("End")


            self.board = self.logic.gamestate
            self.update_score(scoreinc)

        elif event.key() == Qt.Key_Down:
            prev, scoreinc = self.logic.down()
            if prev != self.logic.gamestate:
                self.logic.sample()

            if self.logic.checkend() == 1:
                self.overlay.raise_()
                self.overlay.show()
                print("End")


            self.board = self.logic.gamestate
            self.update_score(scoreinc)
        self.update_board()

    def resizeEvent(self, event):
        self.overlay.setGeometry(self.rect())
        super().resizeEvent(event)

    def restart_game(self):
        self.logic = Game()
        self.logic.start()
        self.update_board()
        self.score = 0
        self.score_label.setText(f"Score: {self.score}")
        self.overlay.hide()
        self.activateWindow()
        self.raise_()
        self.setFocus()







if __name__ == "__main__":
    app = QtWidgets.QApplication(sys.argv)

    widget = MyWidget()
    #widget.resize(800, 600)
    widget.show()

    sys.exit(app.exec())