package br.com.unialfa.nupes.dao;

public interface DAOInterface<T> {
	public void salvar(T obj);

	public void atualizar(T obj);

	public void deletar(Integer id);
}
