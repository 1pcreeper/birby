import { Params } from "react-router-dom";
import StaffsViewLoader from "./loaders/StaffsViewLoader";

class StaffsViewRoute {
    public async loader(params: Params): Promise<StaffsViewLoader> {
        return {
            id: params.id
        } as StaffsViewLoader;
    }
}
export default StaffsViewRoute;