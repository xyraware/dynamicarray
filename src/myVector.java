import java.util.Arrays;

public class myVector<T> {
    public T[] arr;
    public int currentValue;
    public int maxValue;

    public myVector(T[] arr, int value, int maxvalue) {
        this.arr = (T[]) arr;
        this.currentValue = value;
        this.maxValue = maxvalue;
    }

    public void setArr(T[] arr) {
        this.arr = (T[]) arr;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public T[] getArr() {
        return arr;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void sameVector(myVector a) {
        this.arr = (T[]) a.arr;
        this.currentValue = a.currentValue;
        this.maxValue = a.maxValue;
    }

    public <T extends Comparable<T>> myVector add(int index, T element) {
        myVector vectorBuff = null;
        while (true) {
            if (index - 1 == 0) {
                addFirst(element);
                break;
            }
            if (index == currentValue) {
                addLast(element);
                break;
            }
            if ((index - 1 != 0) && ((index != currentValue))) {
                Object[] buff = new Object[this.currentValue + 1];
                while (true) {
                    if (maxValue == currentValue) {
                        maxValue++;
                    } else {
                        currentValue++;
                        for (int i = 0; i < buff.length; i++) {

                            if (i < index - 1) {
                                buff[i] = arr[i];
                            }
                            if (index - 1 == i) {
                                buff[i - 1] = element;
                            }
                            if (i > index - 1) {
                                buff[i] = arr[i - 1];
                            }
                        }
                        vectorBuff = new myVector(buff, buff.length, maxValue);
                        this.sameVector(vectorBuff);
                        break;
                    }
                }
            }
        }
        return this;
    }

    public <T extends Comparable<T>> myVector addFirst(T element) {
        myVector vectorBuff = null;
        Object[] buff = new Object[this.currentValue + 1];
        while (true) {
            if (maxValue == currentValue) {
                maxValue++;
            } else {
                currentValue++;
                for (int i = 0; i < buff.length; i++) {
                    if (i == 0) {
                        buff[0] = element;
                    } else {
                        buff[i] = arr[i - 1];
                    }
                }
                break;
            }
        }
        vectorBuff = new myVector(buff, buff.length, maxValue);
        this.sameVector(vectorBuff);
        return this;
    }

    public <T extends Comparable<T>> myVector addLast(T element) {
        myVector vectorBuff;
        while (true) {
            if (this.currentValue != maxValue) {
                Object[] buff = new Object[this.currentValue + 1];
                for (int i = 0; i < buff.length; i++) {
                    if (i == buff.length - 1) {
                        buff[i] = element;
                        System.out.println(i);
                    } else {
                        buff[i] = arr[i];
                    }
                }
                vectorBuff = new myVector(buff, buff.length, maxValue);
                break;
            } else {
                maxValue++;
            }
        }
        this.sameVector(vectorBuff);
        return this;
    }

    @Override
    public String toString() {
        String s = "\nДинамический массив с максимальным значением: " + maxValue + "\nС текущим значением: " + currentValue + "\nЭлементы: " + Arrays.toString(arr);
        return s;
    }

    public <T extends Comparable<T>> myVector delete(int index) {
        boolean flag=true;
        myVector vectorBuff;
        if(flag) {
            if (index - 1 == 0) {
                Object[] buff = new Object[this.currentValue - 1];
                for (int i = 0; i < buff.length; i++) {
                    buff[i] = arr[i + 1];
                }
                vectorBuff = new myVector(buff, buff.length, maxValue);
                this.sameVector(vectorBuff);
                flag = false;
            }
        }
        if(flag) {
            if (index == currentValue) {
                deleteLast(index);
                flag = false;
            }
        }
        if(flag) {
            if ((index - 1 != 0) && ((index != currentValue))) {
                Object[] buff = new Object[this.currentValue - 1];
                for (int i = 0; i < buff.length; i++) {
                    if (i < index - 1) {
                        buff[i] = arr[i];
                        System.out.println(buff[i]+"+"+i);
                    }

                    if (index - 1 <= i) {
                        buff[i] = arr[i + 1];
                        System.out.println(buff[i]+"+"+i);
                    }
                }
                vectorBuff = new myVector(buff, buff.length, maxValue);
                this.sameVector(vectorBuff);
                flag = false;
            }
        }
        return this;
    }

    public <T extends Comparable<T>> myVector deleteLast(int index) {
        myVector vectorBuff;
        Object[] buff = new Object[this.currentValue-1];
        for (int i = 0; i < buff.length; i++) {
            buff[i] = arr[i];
        }
        vectorBuff = new myVector(buff, buff.length, maxValue);
        this.sameVector(vectorBuff);
        return this;
    }
}

