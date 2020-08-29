package manik.eventsourcing.portfoliomanager.core;

public class BaseEvent<T> {

    public final T id;

    public BaseEvent(T id){
        this.id = id;
    }
}
