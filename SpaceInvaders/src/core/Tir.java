package core;

public abstract class Tir extends Sprite {
	
	protected boolean moved;
	
	protected abstract void avancer();
	
	protected abstract void collision();
	
	public boolean getMoved()
	{
		return moved;
	}
	
	public void setMoved(boolean move)
	{
		this.moved = move;
	}
	
}
