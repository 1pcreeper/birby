import { ActionFunctionArgs, LoaderFunctionArgs } from "react-router-dom";
interface Route {
    loader({ params }: LoaderFunctionArgs<unknown>): Promise<unknown>;
    action({ request, params }: ActionFunctionArgs): Promise<unknown>;
}
export default Route;