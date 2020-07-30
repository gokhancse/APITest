package apitest;

public enum DataManagement {
	API_KEY("apikey"),
    FILM_NAME("s"),
    TYPE("type"),
    YEAR("y"),
    DATA_TYPE("r"),
    PAGE("page"),
    ID("i"),
    TITLE("t");
	
	 DataManagement(String data)
	    {
	        this.data = data;
	    }
	 
    private String data;

    public String getData()
    {
        return data;
    }
    
}
