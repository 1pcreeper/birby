import { LoaderFunctionArgs, redirect, ActionFunctionArgs } from "react-router-dom";
import Route from "./Route";
import StaffsEditLoader from "./loaders/StaffsEditLoader";

class StaffsEditRoute implements Route {
    public async loader({ params }: LoaderFunctionArgs<unknown>): Promise<StaffsEditLoader> {
        return {
            id: params.id
        } as StaffsEditLoader;
    };
    // @ts-ignore
    public async action({ request, params }: ActionFunctionArgs<String>): Promise<unknown> {
        // @ts-ignore
        const formData: FormData = await request.formData();
        // @ts-ignore
        const id: string = params.id;

        return redirect("/");
    };

}
export default StaffsEditRoute;