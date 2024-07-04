class Node{
    int start;
    int end;
    Node next;

    public Node(int s, int e)
    {
        start = s;
        end = e;
        next = null;
    }
}
class Calendar {

    Node head;
    public Calendar() {
        head = new Node(-1, -1);
        head.next = null;
    }

    public boolean book(int start, int end) {
        Node temp = head;
        Node prev = head;
        while(temp != null){
            if(start == temp.start || end == temp.end)
                return false;
            if(!(start <= temp.start && end <= temp.start) && !(start >= temp.end && end >= temp.end ))
                return false;
            if(start <= temp.start && end <= temp.start)
                break;
            prev = temp;
            temp = temp.next;
        }
        Node curr = new Node(start,end);
        prev.next = curr;
        curr.next = temp;
        return true;
    }
}