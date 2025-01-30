import { Params } from "react-router-dom";
import StaffsEditLoader from "./loaders/StaffsEditLoader";

class StaffsEditRoute {
    public async loader(params: Params): Promise<StaffsEditLoader> {
        return {
            id: params.id
        } as StaffsEditLoader;
    }
}
export default StaffsEditRoute;