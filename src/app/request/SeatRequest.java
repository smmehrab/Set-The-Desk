package app.request;

import app.seats.Seat;

public class SeatRequest extends RequestHandler {

    private Seat seat;
    
    public SeatRequest(String username, String type, Seat seat){
        super(username, type);
        this.seat = seat;
    }
}
