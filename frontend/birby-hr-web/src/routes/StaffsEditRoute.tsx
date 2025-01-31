import { LoaderFunctionArgs, ActionFunctionArgs } from "react-router-dom";
import Route from "./Route";

class StaffsEditRoute implements Route {
    public loader({ params }: LoaderFunctionArgs<unknown>): Promise<unknown>;
    public action({ request, params }: ActionFunctionArgs): Promise<unknown>;

}
export default StaffsEditRoute;