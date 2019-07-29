import { Injectable } from "../../node_modules/@angular/core";
import { BehaviorSubject } from '../../node_modules/rxjs';



@Injectable()
export class LoaderService {
    public status: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

    display(value: boolean) {
        this.status.next(value);
    }
}