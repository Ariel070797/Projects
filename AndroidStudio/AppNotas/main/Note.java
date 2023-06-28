public class Note {
    protected int id;
    protected String title;
    protected int priority;

    //Las propiedades de las notas
    public Note (int id, String title, int priority){
        this.id=id;
        this.title=title;
        this.priority=priority;
    }

    public int getId(){

        return this.id;
    }
    public void setId(int id){

        this.id=id;
    }
    public String getTitle(){

        return this.title;
    }
    public void setTitle(String title){

        this.title=title;
    }
    public int getPriority(){

        return this.priority;
    }
    public void setPriority(int priority){

        this.priority=priority;
    }
}
