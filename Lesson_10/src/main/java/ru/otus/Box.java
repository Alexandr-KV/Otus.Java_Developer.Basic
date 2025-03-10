package ru.otus;

public class Box {
    private final int widthOfBox;
    private final int lengthOfBox;
    private final int heightOfBox;
    private String color;
    private boolean isTheBoxOpen;

    private boolean isItemInBox;

    //Конструктор
    public Box(int widthOfBox, int lengthOfBox, int heightOfBox, String color, boolean isTheBoxOpen, boolean isItemInBox) {
        this.widthOfBox = widthOfBox;
        this.lengthOfBox = lengthOfBox;
        this.heightOfBox = heightOfBox;
        this.color = color;
        this.isTheBoxOpen = isTheBoxOpen;
        this.isItemInBox = isItemInBox;
    }

    //getters
    public int getWidthOfBox() {
        return widthOfBox;
    }

    public int getLengthOfBox() {
        return lengthOfBox;
    }

    public int getHeightOfBox() {
        return heightOfBox;
    }

    public String getColor() {
        return color;
    }

    public boolean getIsTheBoxOpen() {
        return isTheBoxOpen;
    }

    public boolean getIsItemInBox() {
        return isItemInBox;
    }

    //Методы
    public void boxInfo() {
        System.out.println("Длинна, ширина и высота коробки равна соответственно " + lengthOfBox + ", " + widthOfBox + ", " + heightOfBox);
        System.out.println("Цвет коробки - " + color);
        if (isTheBoxOpen) {
            System.out.println("Коробка открыта");
        } else {
            System.out.println("Коробка закрыта");
        }
        if (isItemInBox) {
            System.out.println("В коробке лежит предмет");
        } else {
            System.out.println("Коробка пуста");
        }
    }

    public void openTheBox() {
        isTheBoxOpen = true;
        System.out.println("Коробка открыта");
    }

    public void closeTheBox() {
        isTheBoxOpen = false;
        System.out.println("Коробка закрыта");
    }

    public void changeBoxColor(String newColor) {
        color = newColor;
        System.out.println("Коробка перекрашена в " + newColor);
    }

    public void putAnItemInBox(String newItem) {
        if (isTheBoxOpen) {
            if (isItemInBox) {
                System.out.println("Нельзя положить предмет в коробку, т.к. в ней уже что-то лежит");
            } else {
                isItemInBox = true;
                System.out.println("Предмет положен в коробку");
            }
        } else {
            System.out.println("Нельзя положить предмет в коробку, т.к. она закрыта");
        }
    }

    public void throwAnItemOutOfABox() {
        if (isTheBoxOpen) {
            if (isItemInBox) {
                isItemInBox = false;
                System.out.println("Предмет выкинут из коробки");
            } else {
                System.out.println("Из коробки нельзя ничего выкинуть, т.к. в ней ничего нет");
            }
        } else {
            System.out.println("Из коробки нельзя ничего выкинуть, т.к. она закрыта");
        }
    }

}
