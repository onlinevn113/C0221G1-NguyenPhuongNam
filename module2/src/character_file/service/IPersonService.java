package character_file.service;



import java.util.List;

public interface IPersonService<E> {
    boolean add(E e);
    boolean edit(E e, int index);
    boolean delete(int index);
    List<E> list();
    E inputAddOrEdit();
}
