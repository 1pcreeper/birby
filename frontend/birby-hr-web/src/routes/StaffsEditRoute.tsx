import { LoaderFunctionArgs, redirect, ActionFunctionArgs } from "react-router-dom";
import Route from "./Route";
import StaffsEditLoader from "./loaders/StaffsEditLoader";

class StaffsEditRoute implements Route {
    public async loader({ params }: LoaderFunctionArgs<unknown>): Promise<StaffsEditLoader> {
        return {
            id: params.id
        } as StaffsEditLoader;
    };
    public async action({ request, params }: ActionFunctionArgs): Promise<unknown> {
        const formData: FormData = await request.formData();
        const id: string = params.id;
        return redirect("/");
    };

}
export default StaffsEditRoute;