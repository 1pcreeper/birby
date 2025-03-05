import { LoaderFunctionArgs, ActionFunctionArgs } from "react-router-dom";
import Route from "./Route";

class StaffsCreateRoute implements Route {
    // @ts-ignore
    public async loader({ params }: LoaderFunctionArgs<unknown>): Promise<unknown> {
        return {};
    };
    // @ts-ignore
    public async action({ request, params }: ActionFunctionArgs): Promise<unknown> {
        return {};
    };

}
export default StaffsCreateRoute;