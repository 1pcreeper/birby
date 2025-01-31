import { LoaderFunctionArgs } from "react-router-dom";
import StaffsViewLoader from "./loaders/StaffsViewLoader";
import Route from "./Route";

class StaffsViewRoute implements Route {
    public async loader({ params }: LoaderFunctionArgs<unknown>): Promise<StaffsViewLoader> {
        return {
            id: params.id
        } as StaffsViewLoader;
    }
    public async action(): Promise<unknown> {
        return {};
    };
}
export default StaffsViewRoute;