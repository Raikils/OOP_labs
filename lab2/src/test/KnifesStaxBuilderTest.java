package test;

import main.Knife;
import org.junit.Assert;
import parse.KnifesStaxBuilder;
import java.util.ArrayList;
import org.junit.Test;

public class KnifesStaxBuilderTest {
    private KnifesStaxBuilder builder = new KnifesStaxBuilder();

    @Test
    public void parser() {
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
