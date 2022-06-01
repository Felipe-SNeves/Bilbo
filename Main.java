public class Main {

    public static void main (String [] args) {
        attributesGenerator generator = new attributesGenerator ();

        int [] locatorsMethods = new int [] { generator.usingTagName, generator.usingXPath };
        String [] locators = new String [] { "span", "//li/a/span[normalize-space()=\\\"São Paulo - SP\\\"]" };

        generator.openClass ("AttributeAltaBumbleMovelFresh");
        generator.generateSeleniumElementSnippet ("clickCidade", locatorsMethods, locators);
        generator.closeClass ();
    }
}