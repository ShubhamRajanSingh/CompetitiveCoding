package com.java.test;

class CrossNode<E> {

	E data;

	CrossNode<E> nextup, nextdown, nextleft, nextright;
	int Traverse = 0;
	int row, col;
	int Black = -3;
	int BoxLength=0;
	

	public int getBoxLength() {
		return BoxLength;
	}

	public void setBoxLength(int boxLength) {
		this.BoxLength = boxLength;
	}

	public void setTraverse() {
		Traverse = -1;
	}

	public int getTraverse() {
		return Traverse;
	}

	public int getBlack() {
		return Black;
	}

	public void setBlack() {
		this.Black = -2;
	}

	public E getValue() {
		return data;
	}

	public void setValue(E value) {
		this.data = value;
	}

	public CrossNode<E> getNextup() {
		return nextup;
	}

	public void setNextup(CrossNode<E> nextup) {
		this.nextup = nextup;
	}

	public CrossNode<E> getNextdown() {
		return nextdown;
	}

	public void setNextdown(CrossNode<E> nextdown) {
		this.nextdown = nextdown;
	}

	public CrossNode<E> getNextleft() {
		return nextleft;
	}

	public void setNextleft(CrossNode<E> nextleft) {
		this.nextleft = nextleft;
	}

	public CrossNode<E> getNextright() {
		return nextright;
	}

	public void setNextright(CrossNode<E> nextright) {
		this.nextright = nextright;
	}

	public void setrow(int i) {
		this.row = i;
	}

	public void setcol(int i) {
		this.col = i;
	}

	public int getrow() {
		return this.row;
	}

	public int getcol() {
		return this.col;
	}

	public void connectRight(CrossNode<E> g, int i, CrossNode<E> head) {
		CrossNode<E> wptr = null;
		wptr = head;
		while (wptr.getrow() != i) {
			wptr = wptr.getNextdown();
		}
		while (wptr.getNextright() != null) {

			wptr = wptr.getNextright();
		}
		wptr.setNextright(g);
	}

	public void connectLeft(CrossNode<E> g, int i, CrossNode<E> head) {
		CrossNode<E> wptr = null;
		wptr = head;
		while (wptr.getrow() != i) {
			wptr = wptr.getNextdown();
		}
		while (wptr.getNextright() != null) {

			wptr = wptr.getNextright();
		}
		g.setNextleft(wptr);
	}

	public void connectup(CrossNode<E> g, int i, CrossNode<E> head) {
		CrossNode<E> wptr = null;
		wptr = head;
		while (wptr.getcol() != i) {
			wptr = wptr.getNextright();
		}
		while (wptr.getNextdown() != null) {

			wptr = wptr.getNextdown();
		}
		g.setNextup(wptr);
	}

	public void connectdown(CrossNode<E> g, int i, CrossNode<E> head) {
		CrossNode<E> wptr = null;
		wptr = head;
		while (wptr.getcol() != i) {
			wptr = wptr.getNextright();
		}
		while (wptr.getNextdown() != null) {

			wptr = wptr.getNextdown();
		}
		wptr.setNextdown(g);
	}

}