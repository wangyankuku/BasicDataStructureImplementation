package linkedlist;

public class LinkedList<E> {

    Node head;
    Node end;
    int size;

    public LinkedList() {
	head = new Node(null);
	end = head;
    }

    public void add(E e) {
	end.next = new Node(e);
	end = end.next;
	size++;
    }

    public E get(int index) {
	Node target = getNode(index);

	if (target == null) {
	    return null;
	}

	return target.val;
    }

    public boolean set(int index, E e) {
	Node target = getNode(index);
	if (target == null) {
	    return false;
	}

	target.val = e;

	return true;
    }

    public boolean remove(int index) {
	if (index >= size) {
	    return false;
	}

	int n = -1;
	Node cur = head;
	Node pre = null;

	while (n < index) {
	    pre = cur;
	    cur = cur.next;
	    n++;
	}

	pre.next = cur.next;

	if (index == size - 1) {
	    end = pre;
	}

	size--;

	return true;
    }

    private Node getNode(int index) {

	if (index >= size) {
	    return null;
	}

	int n = -1;
	Node cur = head;

	while (n < index) {
	    cur = cur.next;
	    n++;
	}

	return cur;
    }

    class Node {
	E val;
	Node next;

	Node(E val) {
	    this.val = val;
	}
    }
}
