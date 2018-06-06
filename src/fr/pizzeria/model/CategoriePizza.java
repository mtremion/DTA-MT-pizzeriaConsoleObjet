package fr.pizzeria.model;

public enum CategoriePizza 
{
	VIANDE("Viande"),
	POISSON("Poisson"),
	VEGETARIENNE("Végétarienne");
	
	/*************************************************************************************/
	
	private String nom;
	
	/*************************************************************************************/
	
	CategoriePizza()
	{
		this.nom = null;
	}
	
	CategoriePizza(String pNom)
	{
		this.nom = pNom;
	}
	
	/*************************************************************************************/

	public void setNom(String pNom)
	{
		this.nom = pNom;
	}
	
	/*************************************************************************************/

	public String getNom()
	{
		return this.nom;
	}
	
	
	/*public static void getCategorieByLibelle(String pLibelle)
	{
		CategoriePizza[] tabCategorie = CategoriePizza.values();
		
		for(Object o : tabCategorie)
		{
			CategoriePizza categorieLu = (CategoriePizza) o;
			if(categorieLu.getNom().equals(pLibelle))
			{
				return categorieLu;
			}
		}
		
		return null;
	}*/
	
}
