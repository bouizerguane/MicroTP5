import dao.IDao;
import entities.Category;
import entities.Product;
import metier.CategoryDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

public class Presentation3 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Category> categoryDao = context.getBean("categoryDaoImpl",IDao.class);


        Category category = new Category();
        category.setName("cat 1");

        categoryDao.create(category);

        System.out.println("Catégorie sauvegardée : " + category.getName());
    }
}