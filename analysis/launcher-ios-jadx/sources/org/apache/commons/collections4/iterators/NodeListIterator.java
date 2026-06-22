package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes.dex */
public class NodeListIterator implements Iterator<Node> {
    private int index = 0;
    private final NodeList nodeList;

    public NodeListIterator(Node node) {
        if (node == null) {
            throw new NullPointerException("Node must not be null.");
        }
        this.nodeList = node.getChildNodes();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        NodeList nodeList = this.nodeList;
        return nodeList != null && this.index < nodeList.getLength();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() method not supported for a NodeListIterator.");
    }

    @Override // java.util.Iterator
    public Node next() {
        NodeList nodeList = this.nodeList;
        if (nodeList == null || this.index >= nodeList.getLength()) {
            throw new NoSuchElementException("underlying nodeList has no more elements");
        }
        NodeList nodeList2 = this.nodeList;
        int i = this.index;
        this.index = i + 1;
        return nodeList2.item(i);
    }

    public NodeListIterator(NodeList nodeList) {
        if (nodeList != null) {
            this.nodeList = nodeList;
            return;
        }
        throw new NullPointerException("NodeList must not be null.");
    }
}
