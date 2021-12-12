package test;

import main.Knife;
import org.junit.Assert;
import org.junit.Test;
import parse.KnifesDomBuilder;
import java.util.ArrayList;

public class KnifesDomBuilderTest {

    private KnifesDomBuilder builder;

    @Test
    public void parser() {
        builder = new KnifesDomBuilder();
        builder.buildListKnifes("data/Knifes.xml");
        ArrayList<Knife> knifes = builder.getKnifes();
        Assert.assertEquals(knifes.get(0).getId(), "grtew23");
        Assert.assertEquals(knifes.get(1).getId(), "zfrerge12");
        Assert.assertEquals(knifes.get(0).getType(), "knife");
        Assert.assertEquals(knifes.get(1).getType(), "knife");
        Assert.assertEquals(knifes.get(0).getOrigin(), "USA");
        Assert.assertEquals(knifes.get(1).getOrigin(), "Ukraine");
    }
}