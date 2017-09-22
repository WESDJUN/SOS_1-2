package persistencia;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import beans.Servico;

public class ServicoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void inserir(Servico servico) {
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(servico);
		t.commit();
		sessao.close();
	}

	public static void alterar(Servico servico) {
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(servico);
		t.commit();
		sessao.close();
	}

	public static void excluir(Servico servico) {
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(servico);
		t.commit();
		sessao.close();
	}

	public static List<Servico> listagem(String filtro) {
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		Query consulta;
		if (filtro.trim().length() == 0) {
			consulta = sessao.createQuery("from Servico order by ser_id");
		} else {
			consulta = sessao
					.createQuery("from Servico where ser_nome like :parametro order by ser_id");
			consulta.setString("parametro", "%" + filtro + "%");
		}
		List lista = consulta.list();
		sessao.close();
		return lista;

	}

	public static Servico PesqId(int valor) {
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		Query consulta = sessao
				.createQuery("from Servico where ser_id =: parametro");
		consulta.setInteger("parametro", valor);
		sessao.close();
		return (Servico) consulta.uniqueResult();
	}
}
