# JAVA 
## Типы данных
1. Ссылочные 
2. Примитивные:
    - boolean
    - int
    - short (целое малое число)
    - long
    - float
    - double
    - Char (единичный символ)
```java
class Program {
    public static void main(String[] args) {
        float e = 2.7f; //обязательно f
        double pi = 3.1414;
        System.out.println(e); //2.7
        System.out.println(pi); // 3.1415

        boolean f = true & false;
        f = true ^ false; //дизъюнкция

        var i = 123; // неявная типизация

        String s = "querty";
        s.charAt(1); // выведет символ под индексом 1

    }
}
```
## Обьявление переменной
<тип><индентификатор>;   
<индентификатор> = <значение>;  

## Операции Java
- присваивание - `=`
- арифметические: `*`, `/`, `+`,`-`, `%`, `++`, `--`
- операции сравнения: `<`, `>`, `==`, `!`, `>=`, `<=`
- логические операции: `||`, `&&`, `^`, `!`
- побитовые операции: `<<`, `>>` (побитовые сдвиги), `&`, `|`, `^`

```java
class Program {
    public static void main(String[] args) {
    int a = 123;
        System.out.println(a++); // постфиксный инкремент (приоритет операции ниже)

        System.out.println(++a); // префиксный инкремент (приоритет операции выше)
    }
}        

```

## Массивы
```java
class Program {
    public static void main(String[] args) {
        int[] arr = new int[10];
        System.out.println(arr.length); // 10
        arr = new int[] {1, 2, 3, 4, 5}; 
        System.out.println(arr.length); // 5


        int[][] arr = new int[3][5];
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j < arr[i].length; j++) {
                System.out.println('%d', arr[i].length);
            }    
        }
    }
} 
```
## Преобразование 
```java
class Program {
    public static void main(String[] args) {
        int i = 123; double d = i;
        System.out.println(i); // 123
        System.out.println(d); // 123.0

        d = 3.1415; i = int(d);
        System.out.println(d); // 3.1415
        System.out.println(i); // 3

        d = 3.9415; i = int(d);
        System.out.println(d); // 3.9415
        System.out.println(i); // 3

        byte b = Byte.parseByte("123");
        System.out.println(b); // 123

        b = Byte.parseByte("1234");
        System.out.println(b); // NumberFormatException: Value out of range

    }
} 
```

## Получение данных от пользователя
```java 
import java.util.Scanner;
class Program {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("name: ");
        String name = iScanner.nextLine();
        System.out.printf("Привет, %s!", name);
        iScanner.close();

    }
}
```

## Спецификаторы
`%d` - целочисленные значения;   
`%x` - для вывода шестнадцатеричных чисел;   
`%f` - для вывода чисел с плавающей точкой;   
`%e` - для вывода чисел в экспоненцильной форме (например 3,1415е+01);   
`%c` - для вывода одиночного символа;   
`%s` - для вывода строковых значений.

## Функции, методы
```java 
class Program {
    public static void main(String[] args) {
       sayHi(); 

    }

    static void sayHi(){
        System.out.println("Привет!");
    }

    static int sum(int a, int b) {
        return a + b;
    }
}
```

## Управляющие конструкции
```java 
class Program {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c;
        if (a > b) {
            c = a;
        } else {
            c = b;
        }
        System.out.println(c);

        //Тернарный оператор
        int min = a < b ? a : b;
        System.out.println(min);


        // Оператор выбора

        int mounth = value;
        String text = "";
        switch (mounth) {
            case 1:
                text = "Autumn";
                break;
           // ...
            default:
                text = "mistake";
                break;    
        }
        System.out.println(text);
        iScanner.close();

    // Циклы
    // while
        int value = 321;
        int count = 0;
        while (value != 0) {
            value /=10;
            count++;
        }
        System.out.println(count);
    //do while
        do {
            value /=10;
            count++;
        } while (value != 0);   
        System.out.println(count);
    // for (for in)

        int[] arr = int[]{1; 2; 3;};

        for (int item: arr) {
            System.out.println(item); // невозможно работать с итерируемыми обьектами коллекции
        }
    }
}
```

## Работа с файлами
### Создание и запись/дозапись

```java 
import java.io.FileWriter;
import java.io. IOException;

class Program {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("file.txt", false)) {
            fw.write("line_1");
            fw.append('\n');
            fw.append("2");
            fw.append("\n");
            fw.write("line_3");
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage()); // обработка ошибок
        }
    }
}

```

### Чтение, Вариант посимвольно

```java 
import java.io.*;

class Program {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("file.txt");
        int c;
        while ((c = fr.read()) != -1) {
            char ch = (char) c;
            if (ch == '\n') {
                System.out.print(ch);
            } else {
                System.out.print(ch);
            }
        }
    }
}

```
# API
```java
public class Program {
   public static void main(String[] args) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 1_000_000; i++) {
         sb.append("+");
      }
   }   
}
```
## Строки
`contact()` - объединение строк;  
`valueOf()` - преобразует Object в строковое представление (завязан на toString());  
`join()` - объединяет набор строк в одну с учетом разделителся;  
`charAt` - получение символа по индексу;  
`indexOf()` - первый индекс вхождения подстроки;  
`lastIndex()` - последний индекс вхождения подстроки;  
`startsWith()/endsWith()` - определяет, начинается/заканчивается ли строка с подстроки;  
`replace()` - замена одной подстроки на другую;  
`trim()` - удаляет начальные и конечные пробелы;  
`substring()` - возвращает подстроку, см.аргументы;  
`toLowerCAse()/toUpperCase()` - возвращает новую строку в нижнем/верхнем регистре;  
`compareTo()` - сравнивает две строки;  
`equals()` - сравнивает строки с учетом регистра;  
`equalsIgnoreCase()` - сравнивает строки без учета регистра;  
`regionMatches()` - сравнивает подстроки в строках.  

```java
public class Program {
    public static void main(String[] args) {
        String[] name = {"С", "е", "р", "г", "е", "й"};
        String sk = "Сергей КА.";
        System.out.println(sk.toLowerCase()); //сергей ка.
        System.out.println(String.join("", name)); // Сергей
        System.out.println(String.join("", "С", "е", "р", "г", "е", "й")); //Сергей
        System.out.println(String.join("," , "С", "е", "р", "г", "е", "й")); // С,е,р,г,е,й
    }        
}
```
> `String` - много изменений (если вы разбираете готовый полученный материал);  
> `StringBuilder` - много преобразований (если вы собиратае материал).
## Работа с файловой системой. Файлы
```java
public class Program {
   public static void main(String[] args) {
      File f1 = new File("file.txt");
      File f2 = new File("/Users/sk/vscode/file.txt");
   }
}
```
`isHidden()` - возвращает истину, если каталог или файл является срытым;  
`length()` - возвращает размер файла в битах;  
`lastModified()` - возвращает время последнего изменения файла или каталога;  
`list()` - возвращает массив файлов и подкаталогов, которые находятся в каталоге;  
`listFiles()` - возвращает массив файлов и подкаталогов, которые находятся в определенном каталоге;  
`mkdir()` - создает новый каталог;
`renameTo(File dest)` - переименовывает файл или каталог;  


### Ошибки
```java
try {
    Код, в котором может появиться ошибка    
} catch (Exception e) {
    Обработка, если ошибка случилась
} finally {
    Код, который выполнится в любом случае
}

```
## Логирование. Использование. Основы
Использование:
```java
Logger logger = Logger.getLogger(имя класса для которого логирование.class.getName());
```
Уровни важности:  
INFO, DEBUG, ERROR, WARNING и др.  
Вывод:
```java
ConsoleHandler info = new ConsoleHandler(); // FileHandler info = new ConsoleHandler()
logger.addHandler(info);
```

## Тип данных Object
> **Упаковка** - любой тип можно положить в переменную типа Objeсt;  
> **Распаковка** - преобразование Object-переменной в нужный тип;  
> **Иерархия** - любой тип ниже Object.
```java
public  class ex_object {
   public static void main(String[] args) {
      Object o = 1;
      GetType(o);
      o = 1.2;
      GetType();
   }
   static void GetType(Object obj) {
       System.out.println(obj.getClass().getName());
   }
}
```

```java
public  class ex_object {
   public static void main(String[] args) {
    System.out.println((Sum(1, 2)));
    System.out.println((Sum(1.0, 2)));
    System.out.println((Sum(1, 2.0)));
    System.out.println((Sum(1.0, 2.0)));
   }
   
   static Object(Object a, Object b) {
       if (a instanceof Double && b instanceof  Double) {
           return (Object) ((Double) a + (Double) b);
       }else if (a instanceof Integer && b instanceof  Integer) {
          return (Object) ((Integer) a + (Integer) b);
       }else return 0;
   }
   
}
```

## Коллекции
### ArrayList
> List  - пронумерованный набор эдементов.  
> Пользователь этого интерфейса имеет точный контроль над тем, 
> где в списке вставляется каждый элемент.   
> Пользователь может обращаться к элементам по их целочисленному индексу 
> (позиции в списке) и искать элементы в списке.

Разные способы создания:

```java
import java.util.ArrayList;

public class ex_object {
   public static void main(String[] args) {
      ArrayList list = new ArrayList();
      ArrayList<Integer> list1 = new ArrayList<Integer>();
      ArrayList<Integer> list2 = new ArrayList<>();
      ArrayList<Integer> list3 = new ArrayList<>(10);
      ArrayList<Integer> list4 = new ArrayList<>(list3);
   }
}
```
### Функционал

`add(args)` – добавляет элемент в список ( в т.ч. на нужную позицию);  
`get(pos)` – возвращает элемент из списка по указанной позиции;  
`indexOf(item)` – первое вхождение или -1;  
`lastIndexOf(item)` – последнее вхождение или -1;  
`remove(pos)` – удаление элемента на указанной позиции и его возвращение;  
`set(int pos, T item)` – помещает значение item элементу, который находится
на позиции pos;  
`void sort(Comparator)` – сортирует набор данных по правилу;  
`subList(int start, int end)` – получение набора данных от позиции start до end;  
`clear()` – очистка списка;  
`toString()` – «конвертация» списка в строку;  
`Arrays.asList` – преобразует массив в список;  
`containsAll(col)` – проверяет включение всех элементов из col;  
`removeAll(col)` – удаляет элементы, имеющиеся в col;  
`retainAll(col)` – оставляет элементы, имеющиеся в col;  
`toArray()` – конвертация списка в массив Object’ов;  
`toArray(type array)` – конвертация списка в массив type;  
`List.copyOf(col)` – возвращает копию списка на основе имеющегося;  
`List.of(item1, item2,...)` – возвращает неизменяемый список.

### Итератор
>Получение итератора с целью более гибкой работы с данными URL
Интерфейс Iterator<E>.   
> Итератор коллекцией.   
> Iterator занимает место Enumeration в Java Collections Framework. 
> Итераторы отличаются от перечислений двумя способами:
>* Итераторы позволяют вызывающей стороне удалять элементы из
базовой коллекции во время итерации с четко определенной семантикой.  
hasNext(), next(), remove()
>* ListIterator<E> URL  
   hasPrevious(), E previous(), nextIndex(), previousIndex(), set(E e), add(E e)


