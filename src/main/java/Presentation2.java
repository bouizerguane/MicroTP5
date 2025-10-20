import dao.IDao;
import entities.Category;
import entities.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

public class Presentation2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Product> productDao = context.getBean("productDaoImpl",IDao.class);
        IDao<Category> categoryDao = context.getBean("categoryDaoImpl",IDao.class);

        Category category = categoryDao.findById(1);

        Product product = new Product();
        product.setNom("Produit 1");
        product.setCategory(category);
        product.setPrice(300.0);

        productDao.create(product);

        System.out.println("Produit sauvegardé : " + product.getNom());
    }
}