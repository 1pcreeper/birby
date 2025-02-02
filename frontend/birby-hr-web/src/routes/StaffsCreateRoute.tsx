import { LoaderFunctionArgs, ActionFunctionArgs } from "react-router-dom";
import Route from "./Route";

class StaffsCreateRoute implements Route {
    public async loader({ params }: LoaderFunctionArgs<unknown>): Promise<unknown> {
        return {};
    };
    public async action({ request, params }: ActionFunctionArgs): Promise<unknown> {
        return {};
    };

}
export default StaffsCreateRoute;