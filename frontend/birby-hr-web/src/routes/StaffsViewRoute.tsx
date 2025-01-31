import { Params } from "react-router-dom";
import StaffsViewLoader from "./loaders/StaffsViewLoader";
import Route from "./Route";

class StaffsViewRoute implements Route {
    public override async loader(params: Params): Promise<StaffsViewLoader> {
        return {
            id: params.id
        } as StaffsViewLoader;
    }
}
export default StaffsViewRoute;