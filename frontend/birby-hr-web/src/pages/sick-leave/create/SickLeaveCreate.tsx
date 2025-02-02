import { Form, Link, NavigateFunction, useNavigate } from "react-router-dom";
import Container from "../../../components/common/general/Container";
import TitleHeader from "../../../components/common/general/TitleHeader";

function SickLeaveCreate() {
    const navigate: NavigateFunction = useNavigate();
    const handleOnClickCancel = (e: React.MouseEvent<HTMLButtonElement, MouseEvent>) => {
        e.preventDefault();
        navigate(`/sick-leave`);
    }
    return (
        <>
            <Container>
                <TitleHeader title="Sick Leave / Create" />
                <div className="pb-3 gap-x-2 flex">
                    <div className="flex flex-wrap justify-between w-full mb-3 gap-x-2">
                        <button onClick={handleOnClickCancel} type="button" className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                            Back
                        </button>
                        <button type="submit" className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                            Submit
                        </button>
                    </div>
                </div>
                <Form method="POST" action="/sick-leave/create">
                    <div className="mb-3">
                        <label htmlFor="form-name">Leave Name :</label>
                        <input className="border-1" type="text" name="name" id="form-name" />
                        <br />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="form-name">Approvement :</label>
                        <input className="border-1" type="text" name="approvement" id="form-approvement" />
                        <br />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="form-name">Type :</label>
                        <input className="border-1" type="text" name="type" id="form-type" />
                        <br />
                    </div>
                </Form>
            </Container>
        </>
    );
}
export default SickLeaveCreate;