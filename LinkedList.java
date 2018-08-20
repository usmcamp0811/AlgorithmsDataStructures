public class LinkedList {

    Element head;

    static class Element{
        Integer value;
        Element next;

        // similar to __init__ in python AKA a Constructor
        Element(int v) {
            value = v;
            next = null;
        }
    }

    public void append(int value){
        Element new_element = new Element(value);
        Element current = head;

        if(head != null){
            while(current.next != null){
                current = current.next;
            }
            current.next = new_element;
        }else{
            head = new_element;
        }
    }

    public Element get_postion(int position){
        int counter = 1;
        Element current = head;
        if(position < 1){
            return null;
        }
        while(current != null & counter <= position){
            if(counter == position){
                return current;
            }
            current = current.next;
            counter ++;
        }
        return null;
    }

    public void insert(Element new_element, int position){
        int counter = 1;
        Element current = head;
        if(position > 1){
            while(current != null & counter < position){
                if(counter == position - 1){
                    new_element.next = current.next;
                    current.next = new_element;
                }
                current = current.next;
                counter ++;
            }
        }else{
            new_element.next = head;
            head = new_element;
        }
    }

    public void delete(int value){
        Element current = head;
        Element previous = null;
        while(current.value != value & current.next != null){
            previous = current;
            current = current.next;
        }
        if(current.value == value){
            if(previous != null){
                previous.next = current.next;
            }else{
                head = current.next;
            }
        }
    }

    public void printList(){
        // Print it to look like a Python list... cause Python FTW!
        Element e = head;
        System.out.print("[");
        while(e != null){
            System.out.print(e.value);
            if(e.next != null){
                System.out.print(", ");
            }
            e = e.next;
        }
        System.out.print("]");
        System.out.println("");
    }

    public static void main(String [] args){
        // basic usage
        LinkedList llist = new LinkedList();
        llist.append(99);
        llist.append(20);
        llist.append(35);
        System.out.println("LinkedList after appending:");
        llist.printList();
        System.out.println("\nAdd 3 to the LinkedList at Position 2");
        Element new_element = new Element(3);
        llist.insert(new_element, 2);
        System.out.println("llist[2] =  " + llist.get_postion(2).value);
        System.out.println("\nDelete the Value of 99 from the LinkedList");
        llist.delete(99);
        System.out.println("\nShow we what the current LinkedList looks like:");
        llist.printList();

    }


}

