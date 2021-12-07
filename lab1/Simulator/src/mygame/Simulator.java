package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.TextureKey;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Dome;
import com.jme3.scene.shape.Cylinder;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture.WrapMode;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;

public class Simulator extends SimpleApplication {

    public static void main(String[] args) {
        Simulator app = new Simulator();
        app.start();
    }
    
    private BulletAppState bulletAppState;
    
    private Material cylinderMaterial;
    private Material domeMaterial;
    private Material floorMaterial;
    
    private RigidBodyControl cylinderPhysic;
    private static final Cylinder cylinder;
    private RigidBodyControl domePhysic;
    private static final Dome dome;
    private RigidBodyControl floorPhysic;
    private static final Box floor;
    
    static {
        cylinder = new Cylinder(32, 32, 0.1f, 0.5f, true, false);
        
        dome = new Dome(Vector3f.ZERO, 2, 4, 10f,false);
        
        floor = new Box(100f, 0.1f, 100f);
        floor.scaleTextureCoordinates(new Vector2f(3, 6));
    }

    @Override
    public void simpleInitApp() {
        cam.setLocation(new Vector3f(2f, 10f, 2f));
        cam.lookAt(new Vector3f(0, 10f, 0), Vector3f.UNIT_Y);
        
        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);
        
        initMaterials();
        initFloor();
        initDome();
        initCylinder();
    }
    
    private void initMaterials()
    {
        cylinderMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        cylinderMaterial.setColor("Color", ColorRGBA.Blue);
        
        domeMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        TextureKey keyDome = new TextureKey("Textures/Dome/Dome.png");
        keyDome.setGenerateMips(true);
        Texture texDome = assetManager.loadTexture(keyDome);
        domeMaterial.setTexture("ColorMap", texDome);
        
        floorMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        TextureKey keyFloor = new TextureKey("Textures/Floor/Floor.jpg");
        keyFloor.setGenerateMips(true);
        Texture texFloor = assetManager.loadTexture(keyFloor);
        texFloor.setWrap(WrapMode.Repeat);
        floorMaterial.setTexture("ColorMap", texFloor);
    }

    private void initFloor()
    {
        Geometry floorGeometry = new Geometry("Floor", floor);
        floorGeometry.setMaterial(floorMaterial);
        floorGeometry.setLocalTranslation(0, -0.1f, 0);
        rootNode.attachChild(floorGeometry);
        floorPhysic = new RigidBodyControl(0.0f);
        floorGeometry.addControl(floorPhysic);
        bulletAppState.getPhysicsSpace().add(floorPhysic);
    }
    
    private void initDome()
    {
        Geometry cylinderGeometry = new Geometry("dome", dome);
        cylinderGeometry.setMaterial(domeMaterial);
        rootNode.attachChild(cylinderGeometry);
        cylinderGeometry.setLocalTranslation(new Vector3f(0, 0, 0));
        cylinderPhysic = new RigidBodyControl(0f);
        cylinderGeometry.addControl(cylinderPhysic);
        bulletAppState.getPhysicsSpace().add(cylinderPhysic);
    }
    
    private void initCylinder()
    {
         Geometry cylinderGeometry = new Geometry("cylinder", cylinder);
         cylinderGeometry.setMaterial(cylinderMaterial);
         cylinderGeometry.setLocalTranslation(new Vector3f(0.1f, 10f, 0.1f));
         rootNode.attachChild(cylinderGeometry);
         cylinderPhysic = new RigidBodyControl(1f);
         cylinderGeometry.addControl(cylinderPhysic);
         bulletAppState.getPhysicsSpace().add(cylinderPhysic);
         //Node pivot = new Node("pivot");
         //rootNode.attachChild(pivot);
         //pivot.attachChild(cylinderGeometry);
         //pivot.setLocalTranslation(new Vector3f(1f, 10f, 1f));
         //pivot.rotate( 0.3f , 0.0f , 0.3f );
    }
}
