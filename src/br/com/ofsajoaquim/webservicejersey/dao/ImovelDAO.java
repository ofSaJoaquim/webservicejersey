package br.com.ofsajoaquim.webservicejersey.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.ofsajoaquim.webservicejersey.domain.Imovel;

public class ImovelDAO {

    public Imovel salvarImovel(Imovel imovel) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(imovel);
            em.getTransaction().commit();
        } catch (RuntimeException ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return imovel;
    }

    public List<Imovel> selecionarImoveis() {
        EntityManager em = JPAUtil.getEntityManager();

        return em.createQuery("select i from Imovel i", Imovel.class).getResultList();
    }

    public Imovel recuperarImovelPorId(long id) {
        EntityManager em = JPAUtil.getEntityManager();

        return em.find(Imovel.class, id);
    }

    public void atualizarImovel(long imovelId, Imovel imovel) {
        EntityManager em = JPAUtil.getEntityManager();
        Imovel imovelManaged;

        try {
            em.getTransaction().begin();
            imovelManaged = em.find(Imovel.class, imovelId);
            imovelManaged.setNome(imovel.getNome());
            imovelManaged.setDirecionamento(imovel.getDirecionamento());
            imovelManaged.setEndereco(imovel.getEndereco());
            imovelManaged.setValor(imovel.getValor());
            em.getTransaction().commit();
        } catch (RuntimeException ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void excluirImovel(long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Imovel imovel;

        try {
            em.getTransaction().begin();
            imovel = em.find(Imovel.class, id);
            em.remove(imovel);
            em.getTransaction().commit();
        } catch (RuntimeException ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    }