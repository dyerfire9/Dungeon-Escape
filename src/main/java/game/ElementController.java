package game;

import elements.Element;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public abstract class ElementController implements PropertyChangeListener {
    private final Element element;

    public ElementController(Element e) {
        this.element = e;
    }

    public void propertyChange(PropertyChangeEvent evt){};

    public Element getElement(){return this.element;}
}
