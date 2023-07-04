package fr.eni.enchere.groupe6.bll;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import fr.eni.enchere.groupe6.bo.ArticleVendu;
import fr.eni.enchere.groupe6.bo.Categorie;
import fr.eni.enchere.groupe6.dal.ArticleVenduDAO;

@Service
public class ArticleVenduServiceImpl implements ArticleVenduService {

	private ArticleVenduDAO articleVenduDao;
	
	public ArticleVenduServiceImpl(ArticleVenduDAO articleVenduDao) {
		this.articleVenduDao = articleVenduDao;
	}
	
	@Override
	public List<ArticleVendu> afficherArticlesVendus() {
		return articleVenduDao.findAll();
	}

	@Override
	public List<ArticleVendu> afficherArticlesVendusParEtat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleVendu afficherDetailParNoArticle(Integer noArticle) {
		return articleVenduDao.findById(noArticle);
	}

	@Override
	public List<ArticleVendu> afficherResultatRecherche(String nomArticle) {
		// TODO Auto-generated method stub
		return articleVenduDao.findByNom(nomArticle);
	}

	@Override
	public void enregistrerArticle(ArticleVendu articleVendu, Authentication authentication) {
		articleVenduDao.save(articleVendu, authentication);
		
	}

	@Override
	public List<ArticleVendu> afficherResultatParCategorie(Categorie categorie) {
		
		return articleVenduDao.findByCategorie(categorie);
	}
	
	@Override
    public void mettreAJourArticle(ArticleVendu articleVendu) {
        System.out.println("Je passe par la méthode mettreAJourArticle de ArticleVenduServiceImpl");
        articleVenduDao.update(articleVendu);
        
    }
	

}
