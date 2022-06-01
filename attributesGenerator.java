public class attributesGenerator implements locatorUtils, locatorClass {

    public final int usingID = 1;
    public final int usingXPath = 2;
    public final int usingClassName = 3;
    public final int usingTagName = 4;

    public void openClass (String classAttributesName) {
        System.out.println ("public class " + classAttributesName + " extends Object {");
    }

    public void generateSeleniumElementSnippet (String attributeName, int [] locatorMethods, String [] locators) {
        System.out.println ("\tprotected Element <?> " + attributeName + " () {");
        System.out.println ("\t\tSeleniumDescription object = new SeleniumDescription ();");

        int i = 0;
        for (int locatorMethod : locatorMethods) {
            switch (locatorMethod) {
                case usingID: this.locatorByID (locators[i++]); break;
                case usingXPath: this.locatorByXPath (locators[i++]); break;
                case usingClassName: this.locatorByClassName (locators [i++]); break;
                case usingTagName: this.locatorByTagName (locators [i++]);
            }
        }

        System.out.println ("\t\treturn objects (object);");
        System.out.println ("\t}");
    }
    
    public void locatorByID (String id) {
        System.out.println ("\t\tobject.setLocator (By.id (\"" + id + "\"));");
    }

    public void locatorByXPath (String xpath) {
        System.out.println ("\t\tobject.setLocator (By.xpath (\"" + xpath + "\"));");
    }
	
    public void locatorByClassName (String className) {
        System.out.println ("\t\tobject.setLocator (By.className (\"" + className + "\"));");
    }
	
    public void locatorByTagName (String tagName) {
        System.out.println ("\t\tobject.setLocator (By.tagName (\"" + tagName + "\"));");
    }

    public void closeClass () {
        System.out.println ("}");
    }
}