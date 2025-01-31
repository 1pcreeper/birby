import { useLoaderData } from "react-router-dom";
import StaffsViewLoader from "../../../routes/loaders/StaffsViewLoader";
import Container from "../../../components/common/general/Container";
import TitleHeader from "../../../components/common/general/TitleHeader";

function StaffsView() {
    const loaderData: StaffsViewLoader = useLoaderData<StaffsViewLoader>();
    return (
        <>
            <Container>
                <TitleHeader title="Staff Management / Staff" />
                <div className="flex flex-wrap w-full justify-center">
                    <img src="https://fakeimg.pl/500x500/" className="size-60 mb-5" />
                    <div className="grow">
                        <div className="flex justify-between w-full flex-wrap">
                            <div className="p-4 text-2xl ms-5 grow">
                                <h4>
                                    Tag :
                                    <span>
                                        {loaderData.id}
                                    </span>
                                </h4>
                                <h4>
                                    Name :
                                    <span>
                                        {loaderData.id}
                                    </span>
                                </h4>
                                <div className="mb-3">
                                </div>
                                <h4>
                                    Staff ID :
                                    <span>
                                        {loaderData.id}
                                    </span>
                                </h4>
                                <h4>
                                    Email :
                                    <span>
                                        {loaderData.id}
                                    </span>
                                </h4>
                            </div>
                            <div className="text-2xl w-sm bg-amber-100 h-full rounded-2xl">
                                <table className="w-full text-center">
                                    <thead>
                                        <tr className="border-b-2 bg-amber-200 border-amber-400">
                                            <th className="p-2">
                                                Roles
                                            </th>
                                            <th>
                                                Depart.
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr className="p-3">
                                            <td title="XXXXX">
                                                IT Admin
                                            </td>
                                            <td title="XXXXX">
                                                IT
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </Container >
        </>
    );
}
export default StaffsView;