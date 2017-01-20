package behaviour.shapes;

import model.shapes.Shape;

class AddedToShapePoolState implements ShapeState {

    @Override
    public final void handle(final Shape shape) {
    	System.out.println("Shape fell off the screen");
    }

    @Override
    public final boolean hasNext() {
        return false;
    }

    @Override
    public final void goNext(final ShapeContext context) {

    }
}
