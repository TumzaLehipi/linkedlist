
import java.util.*;

public class LinkedList<AnyType> implements Iterable<AnyType>
{
   private Node<AnyType> head;

 
   public LinkedList()
   {
      head = null;
   }
 
   public boolean isEmpty()
   {
      return head == null;
   }
 /**
   *  Inserts a new node at the beginning of this list.
   *
   */
   public void addFirst(AnyType item)
   {
      head = new Node<AnyType>(item, head);
   }
 /**
   *  Returns the first element in the list.
   *
   */
   public AnyType getFirst()
   {
      if(head == null) throw new NoSuchElementException();

      return head.data;
   }
 /**
   *  Removes the first element in the list.
   *
   */
   public AnyType removeFirst()
   {
      AnyType tmp = getFirst();
      head = head.next;
      return tmp;
   }
 /**
   *  Inserts a new node to the end of this list.
   *
   */
   public void addLast(AnyType item)
   {
      if( head == null)
         addFirst(item);
      else
      {
         Node<AnyType> tmp = head;
         while(tmp.next != null) tmp = tmp.next;

         tmp.next = new Node<AnyType>(item, null);
      }
   }
 /**
   *  Returns the last element in the list.
   *
   */
   public AnyType getLast()
   {
      if(head == null) throw new NoSuchElementException();

      Node<AnyType> tmp = head;
      while(tmp.next != null) tmp = tmp.next;

      return tmp.data;
   }
 /**
   *  Removes all nodes from the list.
   *
   */
   public void clear()
   {
      head = null;
   }
 /**
   *  Returns true if this list contains the specified element.
   *
   */
   public boolean contains(AnyType x)
   {
      for(AnyType tmp : this)
         if(tmp.equals(x)) return true;

      return false;
   }
 /**
   *  Returns the data at the specified position in the list.
   *
   */
   public AnyType get(int pos)
   {
      if (head == null) throw new IndexOutOfBoundsException();

      Node<AnyType> tmp = head;
      for (int k = 0; k < pos; k++) tmp = tmp.next;

      if( tmp == null) throw new IndexOutOfBoundsException();

      return tmp.data;
   }
 /**
   *  Returns a string representation
   *
   */
   public String toString()
   {
      StringBuffer result = new StringBuffer();
      for(Object x : this)
      	result.append(x + " ");

      return result.toString();
   }
 /**
   *  Inserts a new node after a node containing the key.
   *
   */
   public void insertAfter(AnyType key, AnyType toInsert)
   {
      Node<AnyType> tmp = head;

      while(tmp != null && !tmp.data.equals(key)) tmp = tmp.next;

      if(tmp != null)
         tmp.next = new Node<AnyType>(toInsert, tmp.next);
   }
 /**
   *  Inserts a new node before a node containing the key.
   *
   */
   public void insertBefore(AnyType key, AnyType toInsert)
   {
      if(head == null) return;

      if(head.data.equals(key))
      {
         addFirst(toInsert);
         return;
      }

      Node<AnyType> prev = null;
      Node<AnyType> cur = head;

      while(cur != null && !cur.data.equals(key))
      {
         prev = cur;
         cur = cur.next;
      }
      //insert between cur and prev
      if(cur != null)
         prev.next = new Node<AnyType>(toInsert, cur);
   }
 /**
   *  Removes the first occurrence of the specified element in this list.
   *
   */
   public void remove(AnyType key)
   {
      if(head == null)
         throw new RuntimeException("cannot delete");

      if( head.data.equals(key) )
      {
         head = head.next;
         return;
      }

      Node<AnyType> cur  = head;
      Node<AnyType> prev = null;

      while(cur != null && !cur.data.equals(key) )
      {
         prev = cur;
         cur = cur.next;
      }

      if(cur == null)
         throw new RuntimeException("cannot delete");

      //delete cur node
      prev.next = cur.next;
   }

   public  LinkedList<AnyType> copy1()
   {
      LinkedList<AnyType> twin = new LinkedList<AnyType>();
      Node<AnyType> tmp = head;
      while(tmp != null)
      {
         twin.addLast( tmp.data );
         tmp = tmp.next;
      }

      return twin;
   }

   public LinkedList<AnyType> copy2()
   {
      LinkedList<AnyType> twin = new LinkedList<AnyType>();
      Node<AnyType> tmp = head;
      while(tmp != null)
      {
         twin.addFirst( tmp.data );
         tmp = tmp.next;
      }

      return twin.reverse();
   }

   public LinkedList<AnyType> reverse()
   {
      LinkedList<AnyType> list = new LinkedList<AnyType>();
      Node<AnyType> tmp = head;
      while(tmp != null)
      {
         list.addFirst( tmp.data );
         tmp = tmp.next;
      }
      return list;
   }

   public LinkedList<AnyType> copy3()
   {
      LinkedList<AnyType> twin = new LinkedList<AnyType>();
      Node<AnyType> tmp = head;
      if(head==null) return null;
      twin.head = new Node<AnyType>(head.data, null);
      Node<AnyType> tmpTwin = twin.head;
      while(tmp.next != null)
      {
         tmp = tmp.next;
         tmpTwin.next = new Node<AnyType>(tmp.data, null);
         tmpTwin = tmpTwin.next;
      }

      return twin;
   }


   private static class Node<AnyType>
   {
      private AnyType data;
      private Node<AnyType> next;

      public Node(AnyType data, Node<AnyType> next)
      {
         this.data = data;
         this.next = next;
      }
   }


   public Iterator<AnyType> iterator()
   {
      return new LinkedListIterator();
   }

   private class LinkedListIterator  implements Iterator<AnyType>
   {
      private Node<AnyType> nextNode;

      public LinkedListIterator()
      {
         nextNode = head;
      }

      public boolean hasNext()
      {
         return nextNode != null;
      }

      public AnyType next()
      {
         if (!hasNext()) throw new NoSuchElementException();
         AnyType res = nextNode.data;
         nextNode = nextNode.next;
         return res;
      }

      public void remove() { throw new UnsupportedOperationException(); }
   }



/*****   Include the main() for testing and debugging  *****/

   static Scanner input = new Scanner(System.in);
   public static void main(String[] args)
   {
       int choice;
       String wordl, word2, word3, word4, word5, word6;
       char y,n;
       
      LinkedList<String> list = new LinkedList <String>();
      list.addFirst("GATE");
      list.addFirst("HATE");
      list.addFirst("FATE");
      list.addFirst("DATE");
      list.addFirst("CATE");
      list.addFirst("BATE");
      list.addFirst("ATE");
      
       LinkedList<String> twin = list.copy3();
    // System.out.println(twin);

      System.out.println("The program will output the desired output depending "
              + "\non your choice from the list below.");
      System.out.println("1. View the list.\n"
                       + "2. add an item on the list.\n"
                       + "3. Add item before.\n"
                       + "4. Insert an item before.\n"
                       + "5. Delete a desired item on a list.\n"
                       + "6. To REVERSE the list.\n");
      
      System.out.println("Enter your choice.");
      choice = input.nextInt();
      
      switch(choice)
      {
        case 1:
                System.out.println(list);
                break;
        case 2:
                
                System.out.println("Enter a string you want at the end.");
                wordl = input.next();
                list.addLast(wordl);
        
               
                Iterator itr = list.iterator();
                while(itr.hasNext())
                System.out.print(itr.next() + " ");
         
                System.out.println();
                for(Object x : list)
                System.out.print(x + " ");
                System.out.println();   
                System.out.println("The previous list is now in reverse form");
                list.copy3();
                System.out.println(list.reverse());
                break;
        case 3: 
                System.out.println(list);
                System.out.println("Enter a word:");
                word2 = input.next();
                System.out.println("After which word you want to enter?");
                word3 = input.next();
                list.insertAfter(word3, word2);
                System.out.println(list);
                System.out.println(list.getLast());
                System.out.println("The previous list is now in reverse form");
                list.copy3();
                System.out.println(list.reverse());
                break;
        case 4:
                System.out.println(list);
                System.out.println("Enter a word:");
                word4 = input.next();
                System.out.println("before which word you want to enter?");
                word5 = input.next();
                list.insertBefore(word5, word4);
                System.out.println(list);
                System.out.println("The previous list is now in reverse form");
                list.copy3();
                System.out.println(list.reverse());
                break;
        case 5:
                System.out.println(list);
                System.out.println("Enter a word you want to delete: ");
                word6 = input.next();
                list.remove(word6);
                System.out.println(list);
                System.out.println("The previous list is now in reverse form");
                list.copy3();
                System.out.println(list.reverse());
              //  list.removeFirst();
               //  System.out.println(list);
                break;
        case 6: 
                System.out.println("The previous list is now in reverse form");
                list.copy3();
                System.out.println(list.reverse());
                break;
                
        default:
                System.out.println("Invalit operation");
      
        }
       
    }
}