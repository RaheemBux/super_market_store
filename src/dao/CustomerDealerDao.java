package dao;

import java.util.List;
import model.CustomerDealer;

public interface CustomerDealerDao {

    public boolean addCustomerDealer(CustomerDealer customerDealer);

    public boolean updateCustomerDealer(CustomerDealer customerDealer);

    public boolean deleteCustomerDealer(Integer id);

    public List<CustomerDealer> getAllCustomerDealer();

    public CustomerDealer getCustomerDealerById(Integer id);

}
