package com.javalab.invoice.service.product;


import java.util.List;

import com.javalab.invoice.dto.Client;

public interface IClientService
{
	public List<Client> getClientList();
	public List<Client> getClientsByName(String client);
	public Client getClient(int client_id);
	public void insertClient(Client client);
//	public void updateCategory(Category category);
//	public void deleteCategory(int category_id);
}
