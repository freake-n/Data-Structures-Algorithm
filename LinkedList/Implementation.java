// Manual implementation of Singly LinkedList

package LinkedList;

public class Implementation{

    public static class Node{
        int data;
        Node next;
        Node(int val){
            this.data=val;
        }
    }

    public static class LinkedList{
        Node head;
        Node tail;
        int size=0;

        void insertAtEnd(int x){
            Node a=new Node(x);
            if(head==null){
                head=tail=a;
            }
            else{
                tail.next=a;
                tail=a;
            }
            size++;
        }

        void insertAtStart(int x){
            Node a=new Node(x);
            if(head==null){
                head=tail=a;
            }
            else{
                a.next=head;
                head=a;
            }
            size++;
        }

        void insertAt(int idx,int x){
            Node a=new Node(x);
            if(idx==size){
                insertAtEnd(x);
                return;
            }
            else if(idx==0){
                insertAtStart(x);
                return;
            }
            else if(idx<0 || idx>size){
                System.out.println("Wrong index !!!");
                return;
            }
            else{
                Node temp=head;
                for(int i=1;i<idx;i++){
                    temp=temp.next;
                }
                a.next=temp.next;
                temp.next=a;
            }
            size++;
        }

        int removeAtStart(){
            if(head==null){
                System.out.println("List is already empty !!!");
                return -999;
            }
            Node temp=head;
            head=head.next;
            size--;
            return temp.data;
        }

        int removeAtEnd(){
            Node temp=head;
            Node lst=tail;
            if(head==null){
                System.out.println("List is already empty !!!");
                return -999;
            }
            else if(size==1){
                temp=head=null;
            }
            else{
                while(temp.next.next!=null){
                temp=temp.next;
                }
                temp.next=null;
            }
            tail=temp;
            size--;
            return lst.data;
        }

        int removeAt(int idx){
            Node temp=head;
            Node lst;
            if(idx==0){
                return removeAtStart();
            }
            else if(idx==size-1){
                return removeAtEnd();
            }
            else if(idx<0 || idx>=size){
                System.out.println("Wrong index !!!");
                return -999;
            }
            else{
                for(int i=1;i<idx;i++){
                    temp=temp.next;
                }
                lst=temp.next;
                temp.next=temp.next.next;
            }
            size--;
            return lst.data;
        }

        int size(){
            return size;
        }

        void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+" -> ");
                temp=temp.next;
            }
            System.out.println("null");
        }

        int getElement(int idx){
            if(idx==0){
                return head.data;
            }
            else if(idx==size-1){
                return tail.data;
            }
            else if(idx<0 || idx>=size){
                System.out.println("Invalid index !!!");
                return -999;
            }

            Node temp=head;
            for(int i=1;i<idx;i++){
                temp=temp.next;
            }
            return temp.next.data;
        }
        
    }

    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.insertAtEnd(0);
        ll.insertAtEnd(1);
        ll.insertAtStart(2);
        ll.insertAtStart(4);
        ll.insertAt(4, 10);
        ll.display();
        System.out.println("Deleted Node : "+ll.removeAt(4));
        ll.display();
        System.out.println(ll.getElement(3));
    }
}
