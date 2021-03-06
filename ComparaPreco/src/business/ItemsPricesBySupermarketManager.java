package business;

import model.ItemsPricesBySupermarket;
import model.PricesByItem;
import model.Supermarket;
import persistence.ComparePriceByNameDAO;
import persistence.ComparePriceDAO;
import persistence.DAOFactory;
import persistence.ItemDAOJDBC;
import persistence.ItemsPricesBySupermarketDAO;
import persistence.PersistenceException;
import persistence.SupermarketDAOJDBC;
import model.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemsPricesBySupermarketManager {

	private List<ItemsPricesBySupermarket> list = new ArrayList();

	public List<ItemsPricesBySupermarket> sumPricesBySupermarket(List<Item> items) throws BusinessException {
		List<Supermarket> supermarkets = new ArrayList();
		SupermarketDAOJDBC supermarketDAO = new SupermarketDAOJDBC();
		try {
			supermarkets = supermarketDAO.getAll();
		} catch (PersistenceException e) {
			throw new BusinessException("Erro ao recuperar todos supermercados", e);
			//e.printStackTrace();
		}
		for (Item item : items) {
			System.out.println("\n Item : " + item.getName());
		}
		for (Supermarket supermarket : supermarkets) {
			ItemsPricesBySupermarket ipbs = this.getItemsPricesBySupermarket(supermarket, items);
			if (ipbs != null) {
				list.add(ipbs);
			}
		}

		return list;

	}

	public ItemsPricesBySupermarket getItemsPricesBySupermarket(Supermarket supermarket, List<Item> items) throws BusinessException {
		ItemsPricesBySupermarket ipbs = null;

		ItemsPricesBySupermarketDAO ipsDAO = new ItemsPricesBySupermarketDAO();

		try {
			ipbs = ipsDAO.getItemsPricesBySupermarket(items, supermarket);
		} catch (PersistenceException e) {
			throw new BusinessException("Erro ao recuperar o objeto pre�os de itens por supermercado", e);
			//e.printStackTrace();
		}

		return ipbs;
	}

	public List<Item> getItems(List<String> namesItems) {
		List<Item> items = new ArrayList();

		for (String name : namesItems) {
			Item item = this.getItemByName(name);
			items.add(item);

		}
		return items;
	}

	public Item getItemByName(String name) {
		// TODO //N�o deu certo dessa forma:
		// ComparePriceByNameDAO<Item> itemDao = new DAOFactory().getItemDAO();
		// TODO // como deixo compare price pra pegar o get com nome???
		ItemDAOJDBC itemDao = new ItemDAOJDBC();
		Item selectedItem = itemDao.get(name);
		return selectedItem;
	}
}
