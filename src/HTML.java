import java.util.ArrayList;
interface printable{
    public String toString();
}
class Attr{
    String key;
    String value;
    Attr(String key,String value){
        this.key=key;
        this.value=value;
    }

    @Override
    public String toString() {
        String.format("%s=\"\"",key,value);
    }
}
class Tag{
    String name;
    ArrayList<Attr> attrs;
    String content;


    @Override
    public String toString(){
        return String.format("<%s> %s>%s</%s>", name, getAttrs(), content, name);
    }
    String getAttrs(){
        ArrayList<String>list=new ArrayList<>();
        for(Attr a:attrs){
            list.add(a.toString());

        }
        return String.join(" ",list);
    }
    class Strong extends Tag{
        Strong(String content){
        super( "B", null, content);
    }
}
class Warning extends Div{
    Div div;
    Warning(String content){
        new ArrayList<Attr>attrs=newArrayList<Attr>();
        attrs.add(new Attr("id","123"));
        attrs.add(new Attr("class","box warning"));

        this.div=new Div(attrs,"WARNING: ");
    }
    public String toString(){
    return div.toString();
}
}
public class HTML {
    public static void main(String[] args) {
        System.out.println(new Warning("This is a warning!"));

    }
}
