
public interface ItemDAO {

	public abstract boolean save(int key, Item item);
	//public abstract void edit(String cpf,User user);
	public abstract void list();
	public abstract boolean checksExistence(int key);
	public abstract Item get(int key);
	public abstract void delete(int key);
	

}